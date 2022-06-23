//2
package com.example.spotify

data class Config(
    val footer: FooterX,
    val genres: List<String>,
    val sections: List<Section>,
    val vendorId: String,
    val vendorName: String
)