package com.github.oovm.re0intellij.services

import com.intellij.openapi.project.Project
import com.github.oovm.re0intellij.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
