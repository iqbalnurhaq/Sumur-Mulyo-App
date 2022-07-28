package com.nurhaq.sumurmulyo.model.response.base

class ApiBaseResponse<T>(
    val data: T,
    val meta: Meta
)