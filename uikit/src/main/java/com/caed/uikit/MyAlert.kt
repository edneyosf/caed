package com.caed.uikit

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.caed.uikit.value.Colors

@Composable
fun MyAlert(dialogTitle: String, dialogText: String, onDismiss: () -> Unit) {
    val textButton = stringResource(id = R.string.close_button)

    AlertDialog(
        containerColor = Colors.WHITE,
        title = { Text(text = dialogTitle) },
        text = { Text(text = dialogText, color = Colors.TEXT) },
        onDismissRequest = {},
        confirmButton = {},
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(textButton, color = Colors.BLACK)
            }
        }
    )
}

@Preview
@Composable
private fun Default() = MyAlert(dialogTitle = "Sample", dialogText = "Sample") {}