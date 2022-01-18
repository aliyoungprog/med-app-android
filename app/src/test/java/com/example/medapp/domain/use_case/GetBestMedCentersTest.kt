package com.example.medapp.domain.use_case

import com.example.medapp.domain.repository.MedCenterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class GetBestMedCentersTest {

    private lateinit var getBestMedCentersUseCase: GetBestMedCenters

    @Mock
    private lateinit var medCenterRepository: MedCenterRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        getBestMedCentersUseCase = Mockito.spy(GetBestMedCenters(medCenterRepository))
    }

    @Test
    fun getBestMedCentersValidator() {
        val result = CoroutineScope(Dispatchers.Main).launch {
            getBestMedCentersUseCase.invoke()
        }
        Assert.assertNotNull(result)
    }
}
