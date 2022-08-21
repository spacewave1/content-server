package com.spacewave.contentserver

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.util.HtmlUtils
import java.io.File
import java.io.InputStream
import java.io.DataInputStream

fun ByteArray.toHex(): String = joinToString(separator = "") { eachByte -> "%02x".format(eachByte)}

@Controller
class ThreeDimensionalResourcesController {

    @MessageMapping("/fbx-models")
    @SendTo("/topic/fileAccess")
    fun getFbxResource(fileAccess: FileAccess) : ThreeDimensionalResource {
    	val fileName = fileAccess.fileName

    	val fileContent : ByteArray = File("src/main/resources/threeDimensional/$fileName.fbx").readBytes()
        return ThreeDimensionalResource(fileContent.toHex(), "fbx");
    }

    @MessageMapping("/gltf-models")
    @SendTo("/topic/fileAccess")
    fun getGltfResource(fileAccess: FileAccess) : ThreeDimensionalResource {
    	val fileName = fileAccess.fileName

    	val fileContent : String = File("src/main/resources/threeDimensional/$fileName.gltf").readText(Charsets.UTF_8)
        return ThreeDimensionalResource(fileContent, "gltf");
    }
}
