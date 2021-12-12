package com.example.medapp.di

import com.example.medapp.data.datasource.RetrofitBuilder
import com.example.medapp.data.repositoryimpl.DefaultMedCenterRepository
import com.example.medapp.data.repositoryimpl.DefaultUserRepository
import com.example.medapp.domain.repository.MedCenterRepository
import com.example.medapp.domain.repository.UserRepository
import com.example.medapp.domain.use_case.AddUserUseCase
import com.example.medapp.domain.use_case.AuthorizationUseCase
import com.example.medapp.domain.use_case.GetAllMedServicesUseCase
import com.example.medapp.domain.use_case.GetBestMedCenters
import com.example.medapp.presentation.main.viewmodel.AboutMedCenterViewModel
import com.example.medapp.presentation.main.viewmodel.MainFragmentViewModel
import com.example.medapp.presentation.registration.viewmodel.AuthViewModel
import com.example.medapp.presentation.registration.viewmodel.RegistrationViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        MainFragmentViewModel(
            getBestMedCenters = get()
        )
    }
    viewModel {
        AboutMedCenterViewModel(
            getAllMedServicesUseCase = get()
        )
    }
    viewModel {
        RegistrationViewModel(
            addUserUseCase = get()
        )
    }
    viewModel{
        AuthViewModel(
            authorizationUseCase = get()
        )
    }
}

val useCaseModule = module {
    factory {
        GetAllMedServicesUseCase(
            medCentersRepository = get()
        )
    }
    factory {
        GetBestMedCenters(
            medCentersRepository = get()
        )
    }

    factory {
        AddUserUseCase(
            userRepository = get()
        )
    }
    factory {
        AuthorizationUseCase(
            userRepository = get()
        )
    }
}


val repositoryModule = module {

    single {
        RetrofitBuilder()
    }

    single<MedCenterRepository> {
        DefaultMedCenterRepository(
            retrofitBuilder = get()
        )
    }

    single<UserRepository> {
        DefaultUserRepository(
            retrofitBuilder = get()
        )
    }

}
