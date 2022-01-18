package com.example.medapp.di

import com.example.medapp.data.datasource.RetrofitBuilder
import com.example.medapp.data.repositoryimpl.DefaultDoctorRepository
import com.example.medapp.data.repositoryimpl.DefaultMedCenterRepository
import com.example.medapp.data.repositoryimpl.DefaultUserRepository
import com.example.medapp.domain.repository.DoctorRepository
import com.example.medapp.domain.repository.MedCenterRepository
import com.example.medapp.domain.repository.UserRepository
import com.example.medapp.domain.use_case.*
import com.example.medapp.presentation.main.viewmodel.AboutMedCenterViewModel
import com.example.medapp.presentation.main.viewmodel.DoctorViewModel
import com.example.medapp.presentation.main.viewmodel.MainFragmentViewModel
import com.example.medapp.presentation.registration.viewmodel.AuthViewModel
import com.example.medapp.presentation.registration.viewmodel.RegistrationViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        MainFragmentViewModel(
            getBestMedCenters = get(),
            getAllNewsUseCase = get()
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
    viewModel {
        AuthViewModel(
            authorizationUseCase = get()
        )
    }

    viewModel {
        DoctorViewModel(
            getAllDoctorsUseCase = get(),
            getDoctorByIdUseCase = get()
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

    factory {
        GetAllDoctorsUseCase(
            doctorRepository = get()
        )
    }
    factory {
        GetDoctorByIdUseCase(
            doctorRepository = get()
        )
    }

    factory {
        GetAllNewsUseCase(

            medCentersRepository = get()
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

    single<DoctorRepository> {
        DefaultDoctorRepository(
            retrofitBuilder = get()
        )
    }

}
