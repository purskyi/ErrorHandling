package com.example.errorhandling.domain

sealed interface DataError: Error {
    enum class NetWork: DataError{
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        NO_INTERNET,
        PAYLOAD_TOO_LARGE,
        SERIALIZATION,
        UNKNOWN
    }
    enum class Local: DataError{
        DISK_FULL,

    }
}