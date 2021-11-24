package com.example.medapp.di

import com.example.medapp.data.repositoryimpl.DefaultMedServiceRepository
import com.example.medapp.domain.repository.MedServiceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {
    @Binds fun bindRepository(impl: DefaultMedServiceRepository): MedServiceRepository
}
