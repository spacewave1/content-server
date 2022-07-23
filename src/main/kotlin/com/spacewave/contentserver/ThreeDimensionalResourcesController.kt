package com.spacewave.contentserver

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.util.HtmlUtils
import java.io.File
import java.io.InputStream
import java.io.DataInputStream

@Controller
class ThreeDimensionalResourcesController {

    @MessageMapping("/fbx-models")
    @SendTo("/topic/fileAccess")
    fun getResource(fileAccess: FileAccess) : ThreeDimensionalResource {
    	val fileName = fileAccess.fileName

    	// TODO: Figure out how to transport binary files
    	val fileContent : String = DataInputStream(File("src/main/resources/threeDimensional/$fileName.fbx").inputStream())readFully()
        return ThreeDimensionalResource(fileContent, "fbx");
    }

}
