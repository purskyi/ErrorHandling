package com.example.errorhandling.domain

typealias RootError = Error

sealed interface MineResult<out D, out E: RootError> {
    data class Success<out D, out E: RootError>(val data: D): MineResult<D, E>
    data class Error<out D, out E: RootError>(val error: E): MineResult<D, E>
}