package it.sarni.ipakmm.presentation.features.beer

import it.sarni.ipakmm.presentation.models.UiState
import it.sarni.ipakmm.domain.usecase.GetBeers
import it.sarni.ipakmm.domain.usecase.GetBeersResponse
import it.sarni.ipakmm.presentation.base.BaseViewModel
import it.sarni.ipakmm.presentation.helpers.CFlow
import it.sarni.ipakmm.presentation.helpers.asCommonFlow
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

class BeerViewModel(private val getBeers: GetBeers) : BaseViewModel() {

    private val _loadBeersState = MutableStateFlow<UiState<GetBeersResponse>?>(null)
    val loadBeersState: CFlow<UiState<GetBeersResponse>> get() = _loadBeersState.filterNotNull().asCommonFlow()

    init {
        clientScope.launch(CoroutineExceptionHandler { _, throwable ->
            _loadBeersState.value = UiState.Error(throwable,null)
        }) {
            _loadBeersState.value = UiState.Loading()
            _loadBeersState.value = UiState.Success(data = getBeers())
        }
    }


}