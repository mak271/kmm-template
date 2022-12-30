package com.involta.textile.core

import com.adeo.kviewmodel.BaseSharedViewModel

abstract class BaseViewModel<State : Any, Action, Event>(initialState: State) :
    BaseSharedViewModel<State, Action, Event>(initialState) {
    fun completeAction() {
        viewAction = null
    }
}