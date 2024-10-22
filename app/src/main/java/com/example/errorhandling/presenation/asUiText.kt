package com.example.errorhandling.presenation

import com.example.errorhandling.R
import com.example.errorhandling.domain.DataError
import com.example.errorhandling.domain.MineResult

fun DataError.asUiText(): UiText {
    return when (this) {
        DataError.NetWork.REQUEST_TIMEOUT -> UiText.StringResource(
            R.string.the_request_timed_out
        )

        DataError.NetWork.TOO_MANY_REQUESTS -> UiText.StringResource(
            R.string.youve_hit_your_rate_limit
        )

        DataError.NetWork.NO_INTERNET -> UiText.StringResource(
            R.string.no_internet
        )

        DataError.NetWork.PAYLOAD_TOO_LARGE -> UiText.StringResource(
            R.string.file_too_large
        )

        DataError.NetWork.SERIALIZATION -> UiText.StringResource(
            R.string.error_serialization
        )

        DataError.NetWork.UNKNOWN -> UiText.StringResource(
            R.string.unknown_error
        )

        DataError.Local.DISK_FULL -> UiText.StringResource(
            R.string.error_disk_full
        )

    }
}

fun MineResult.Error<*, DataError>.asErrorUiText(): UiText {
    return error.asUiText()
}