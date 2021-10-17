package com.geekbrains.tests.presenter.details

import androidx.annotation.VisibleForTesting
import com.geekbrains.tests.view.details.ViewDetailsContract

internal class DetailsPresenter internal constructor(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    var viewContract: ViewDetailsContract?,
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    var count: Int = 0,
) : PresenterDetailsContract {

    override fun setCounter(count: Int) {
        this.count = count
    }

    override fun onIncrement() {
        count++
        viewContract?.setCount(count)
    }

    override fun onDecrement() {
        count--
        viewContract?.setCount(count)
    }

    override fun onAttach(view: ViewDetailsContract) {
        this.viewContract = view
    }

    override fun onDetach() {
        viewContract = null
    }
}
