package com.example.medapp.di

import com.example.medapp.data.datasource.RetrofitBuilder
import com.example.medapp.data.repositoryimpl.DefaultMedCenterRepository
import com.example.medapp.domain.repository.MedCenterRepository
import com.example.medapp.domain.use_case.GetAllMedServicesUseCase
import com.example.medapp.domain.use_case.GetBesMedCenters
import com.example.medapp.presentation.main.viewmodel.AboutMedCenterViewModel
import com.example.medapp.presentation.main.viewmodel.MainFragmentViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        MainFragmentViewModel(
            getBesMedCenters = get()
        )
    }
    viewModel {
        AboutMedCenterViewModel(
            getAllMedServicesUseCase = get()
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
        GetBesMedCenters(
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

}
