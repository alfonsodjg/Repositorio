package com.example.repositorio.ui.modules.home.view

import android.content.Intent
import android.net.Uri
import android.provider.ContactsContract.Intents
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.repositorio.core.utils.SaveToken
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.repositorio.R
import com.example.repositorio.components.CustomBottomBarComponent
import com.example.repositorio.ui.modules.home.model.BookModelUI
import com.example.repositorio.ui.modules.home.view_provider.MockProviderHome
import com.example.repositorio.ui.theme.AppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview(
    device = Devices.PIXEL_2,
    showSystemUi = true,
    showBackground = true
)
@Composable
fun HomePreView() {
    AppTheme {
        HomeView(
            onGoToHome = {},
            onGoToProfile = {},
            onGoToAbout = {},
            onGoToAdmin = {},
            books = emptyList()
        )
    }
}

@Composable
fun HomeView(
    onGoToHome: () -> Unit,
    onGoToProfile: () -> Unit,
    onGoToAbout: () -> Unit,
    onGoToAdmin: () -> Unit,
    books: List<BookModelUI.BookListResponse>,
    onDownloadBook: (String) -> Unit = {},
    onShareBook: (String) -> Unit = {}
) {
    val systemUiController = rememberSystemUiController()
    val statusBarColor = Color.Yellow
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    var searchQuery by remember { mutableStateOf("") }

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = true
        )
    }

    val filteredBooks = books.filter { it.title.contains(searchQuery, ignoreCase = true) }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                })
            }
            .background(AppTheme.colors.containerColor)
            .windowInsetsPadding(WindowInsets.ime)
    ) {
        val (search,header, footer) = createRefs()

        Box(
            modifier = Modifier.constrainAs(search){
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }
        ) {
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .padding(top = 10.dp, end = 10.dp, start = 10.dp)
                    .fillMaxWidth(),
                placeholder = { Text(text = "Buscar libro") },
                singleLine = true,
                shape = RoundedCornerShape(14.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = AppTheme.colors.cardColor,
                    unfocusedContainerColor = AppTheme.colors.cardColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Buscar"
                    )
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = {
                            searchQuery = ""
                            focusManager.clearFocus()
                        }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Limpiar búsqueda"
                            )
                        }
                    }
                }
            )
        }
        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .constrainAs(header) {
                    top.linkTo(search.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(footer.top)
                    height = Dimension.fillToConstraints
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.largo),
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 5.dp)
            )
            if (filteredBooks.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_no_books),
                        contentDescription = null,
                        modifier = Modifier.size(160.dp),
                        colorFilter = ColorFilter.tint(Color(0xFF602970))
                    )
                }
                Text(
                    text = "No se encontraron libros",
                    modifier = Modifier.padding(16.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.W500,
                    color = AppTheme.colors.textColor
                )
            }else {
                filteredBooks.forEach { book ->
                    BookCard(
                        book = book,
                        onDownloadBook = { onDownloadBook(book.pdfFile) },
                        onShareBook = { onShareBook(book.pdfFile) }
                    )
                }
            }
        }
        Box(
            modifier = Modifier.constrainAs(footer) {
                start.linkTo(parent.start)
                top.linkTo(header.bottom)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        ) {
            CustomBottomBarComponent(
                onGoToHome = onGoToHome,
                onGoToProfile = onGoToProfile,
                onGoToAbout = onGoToAbout,
                onGoToAdmin = onGoToAdmin
            )
        }
    }
}

@Composable
fun BookCard(
    book: BookModelUI.BookListResponse,
    onDownloadBook: () -> Unit = {},
    onShareBook: () -> Unit
) {
    val context = LocalContext.current
    Surface(
        modifier = Modifier
            .padding(top = 10.dp, start = 16.dp, end = 16.dp, bottom = 10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        color = AppTheme.colors.cardColor,
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = book.image,
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
                Text(
                    text = book.title,
                    fontSize = 16.sp,
                    color = AppTheme.colors.textColor
                )
                Text(
                    text = book.resume,
                    fontSize = 14.sp,
                    color = AppTheme.colors.textColor
                )
            }
            Column(
                modifier = Modifier
                    .weight(0.6f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFE6E6E6))
                        .clickable {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(book.pdfFile))
                            context.startActivity(intent)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.eye_ic),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Text(
                    text = "Ver",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    color = AppTheme.colors.textColor,
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(book.pdfFile))
                        context.startActivity(intent)
                    }
                )
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFE6E6E6))
                        .clickable {
                            onDownloadBook()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.download_ic),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Text(
                    text = "Descargar",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    color = AppTheme.colors.textColor,
                    modifier = Modifier.clickable { onDownloadBook() }
                )
                /*Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFE6E6E6))
                        .clickable {
                            onShareBook()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.share_ic),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Text(
                    text = "Compartir",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    color = AppTheme.colors.textColor,
                    modifier = Modifier.clickable { onShareBook() }
                )*/
            }
        }
    }
}