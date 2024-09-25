package com.example.repositorio.data.modules.home.resource

import com.example.repositorio.data.network.endpoint.ApiEndpoint
import io.ktor.resources.Resource

@Resource("")
class BookResource(){
    @Resource(ApiEndpoint.GET_ALL_BOOKS)
    class BookResourceItem(val parent: BookResource = BookResource())

    @Resource(ApiEndpoint.DOWNLOAD_BOOK_PDF)
    class BookPDF(val parent: BookResource = BookResource(), val id: Int)
}