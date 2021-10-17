package com.geekbrains.tests.presenter.details

import com.geekbrains.tests.view.details.ViewDetailsContract
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class DetailsPresenterTest {

    private lateinit var presenter: DetailsPresenter
    private var count = 0

    @Mock
    private lateinit var viewContract: ViewDetailsContract

    @Mock
    private lateinit var viewContract2: ViewDetailsContract

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this).close()
        presenter = DetailsPresenter(viewContract, count)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `verify viewContract has setCount()`() {
        viewContract.setCount(42)
        verify(viewContract, times(1)).setCount(42)
    }

    @Test
    fun `should be a set number`() {
        val expected = 42
        presenter.setCounter(42)
        val actual = presenter.count
        assertEquals(expected, actual)
    }

    @Test
    fun `should increase by one`() {
        val expected = 1
        presenter.onIncrement()
        val actual =  presenter.count
        assertEquals(expected, actual)
    }

    @Test
    fun `should decrease by one`() {
        val expected = -1
        presenter.onDecrement()
        val actual = presenter.count
        assertEquals(expected, actual)
    }

    @Test
    fun `should view is viewContract2`() {
        val expected = viewContract2
        presenter.onAttach(viewContract2)
        assertEquals(expected, presenter.viewContract)
    }

    @Test
    fun `should view is null`() {
        presenter.onDetach()
        assertNull(presenter.viewContract)
    }
}