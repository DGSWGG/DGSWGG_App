package kr.hs.dgsw.domain.base

interface FlowUseCase<T> {
    fun buildFlowUseCase(): T
}