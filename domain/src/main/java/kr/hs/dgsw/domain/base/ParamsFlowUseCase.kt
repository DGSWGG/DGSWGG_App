package kr.hs.dgsw.domain.base

interface ParamsFlowUseCase<Params, T> {
    fun buildParamsFlowUseCase(params: Params): T
}