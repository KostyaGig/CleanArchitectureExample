package com.admin.mylectionlearn.presentation.viewmodel

import com.admin.mylectionlearn.data.mapper.Mapper
import com.admin.mylectionlearn.data.model.PostDataModel
import com.admin.mylectionlearn.data.net.CloudDataSource
import com.admin.mylectionlearn.data.net.model.PostServerModel
import com.admin.mylectionlearn.domain.PostInteractor
import com.admin.mylectionlearn.domain.model.Post
import com.admin.mylectionlearn.domain.repository.PostRepository
import com.admin.mylectionlearn.presentation.Communication
import com.admin.mylectionlearn.presentation.model.BasePostUiModel
import com.admin.mylectionlearn.presentation.model.PostUiModel
import junit.framework.TestCase

class PostViewModelTest : TestCase() {
    @Test
    fun test_fetch_post_success() {
        val mapperFromServerModelToPostDataModel = Mapper.MapperFromServerModelToDataModel()
        val cloudDataSource = TestCloudDataSource()
        val repository = TestPostRepository(cloudDataSource,mapperFromServerModelToPostDataModel)
        val mapperFromPostDataToPostSuccess = Mapper.MapperFromPostDataToPostSuccess()
        val interactor = TestPostInteractor(repository,mapperFromPostDataToPostSuccess)
        val communication = TestCommunication()
        val viewModel = TestViewModel(interactor,communication)

        val postUiModel = viewModel.fetchPost()
        assertEquals(1,communication.countShow)
        assertTrue(postUiModel is BasePostUiModel)
    }

    private inner class TestViewModel(
        private val interactor: PostInteractor,
        private val communication: Communication
    ) {
        fun fetchPost(): PostUiModel {
            val postUiModel = interactor.getPost().map()
            postUiModel.show(communication)
            return postUiModel
        }
    }

    private inner class TestCommunication: Communication {
        var countShow = 0
        override fun show(postUiModel: PostUiModel) {
            countShow++
        }
    }

    private inner class TestPostInteractor(
        private val testPostRepository: PostRepository,
        private val mapperFromPostDataToPostSuccess: Mapper<Post.Success>
    ): PostInteractor {
        override fun getPost(): Post {
            return testPostRepository.getPost().map(mapperFromPostDataToPostSuccess)
        }
    }

    private inner class TestPostRepository (
        private val testCloudDataSource: CloudDataSource,
        private val testMapperFromServerModelToPostModel: Mapper<PostDataModel>
            ): PostRepository {
        override suspend fun getPost(): PostDataModel {
            return testCloudDataSource.fetchPost().map(testMapperFromServerModelToPostModel)
        }
    }

    private inner class TestCloudDataSource: CloudDataSource {
        override suspend fun fetchPost(): PostServerModel {
            return PostServerModel(1,"MyTitle","MyBody")
        }
    }
}