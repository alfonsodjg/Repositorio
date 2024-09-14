package com.example.repositorio.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repositorio.ui.modules.add_file_admin.model.AuthorsModelUI
import com.example.repositorio.ui.modules.add_file_admin.model.PublicTypesModelUI
import com.example.repositorio.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> SpinnerComponent(
    items: List<T>,
    text: String,
    labelSelector: (T) -> String,
    modifier: Modifier = Modifier,
    selectedOptionIndex: Int? = null,
    onOptionSelected: (Int) -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }
    val selectedOption = selectedOptionIndex?.let { items.getOrNull(it) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
            modifier = Modifier
                .background(AppTheme.colors.cardColor)
        ) {
            TextField(
                value = selectedOption?.let { labelSelector(it) } ?: "",
                onValueChange = {},
                readOnly = true,
                label = {
                    Text(
                        text = text,
                        color = AppTheme.colors.textColor
                    )
                },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .clickable { expanded = true },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = AppTheme.colors.containerColor,
                    unfocusedContainerColor = AppTheme.colors.containerColor
                )
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                items.forEachIndexed { index, item ->
                    DropdownMenuItem(
                        text = { Text(labelSelector(item)) },
                        onClick = {
                            onOptionSelected(index)
                            expanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpinnerExamplePreview() {
    AppTheme {
        val authors = listOf(
            AuthorsModelUI(name = "Author 1"),
            AuthorsModelUI(name = "Author 2"),
            AuthorsModelUI(name = "Author 3")
        )

        val types = listOf(
            PublicTypesModelUI(name = "Type 1"),
            PublicTypesModelUI(name = "Type 2"),
            PublicTypesModelUI(name = "Type 3")
        )

        Column {
            SpinnerComponent(
                items = authors,
                text = "Select Author",
                labelSelector = { it.name }
            )
            SpinnerComponent(
                items = types,
                text = "Select Type",
                labelSelector = { it.name }
            )
        }
    }
}