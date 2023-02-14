package com.example.androidapplicationtemplate.ui.someFeature

import com.example.androidapplicationtemplate.core.platform.AdapterItem
import com.example.androidapplicationtemplate.data.models.entity.Entity1
import com.example.androidapplicationtemplate.data.models.entity.Entity2
import com.example.androidapplicationtemplate.data.models.entity.Entity3
import com.example.androidapplicationtemplate.data.models.entity.Entity4

object ListHelperClass {

    fun getList() : List<AdapterItem> {
        val list = mutableListOf<AdapterItem>()
        list.add(Entity1("View 1"))
        list.add(Entity2("View 2"))
        list.add(
            Entity3(listOf(
                Entity4("Nested Item 1"),
            Entity4("Nested Item 2"),
            Entity4("Nested Item 3"),
            Entity4("Nested Item 4")
            ))
        )
        list.add(Entity1("View 1"))
        list.add(Entity2("View 2"))
        list.add(
            Entity3(listOf(
                Entity4("Nested Item 1"),
            Entity4("Nested Item 2"),
            Entity4("Nested Item 3"),
            Entity4("Nested Item 4")
            ))
        )
        list.add(Entity1("View 1"))
        list.add(Entity2("View 2"))
        list.add(
            Entity3(listOf(
                Entity4("Nested Item 1"),
            Entity4("Nested Item 2"),
            Entity4("Nested Item 3"),
            Entity4("Nested Item 4")
            ))
        )
        list.add(Entity1("View 1"))
        list.add(Entity2("View 2"))
        list.add(
            Entity3(listOf(
                Entity4("Nested Item 1"),
            Entity4("Nested Item 2"),
            Entity4("Nested Item 3"),
            Entity4("Nested Item 4")
            ))
        )
        list.add(Entity1("View 1"))
        list.add(Entity2("View 2"))
        list.add(
            Entity3(listOf(
                Entity4("Nested Item 1"),
            Entity4("Nested Item 2"),
            Entity4("Nested Item 3"),
            Entity4("Nested Item 4")
            ))
        )
        list.add(Entity1("View 1"))
        list.add(Entity2("View 2"))
        list.add(
            Entity3(listOf(
                Entity4("Nested Item 1"),
            Entity4("Nested Item 2"),
            Entity4("Nested Item 3"),
            Entity4("Nested Item 4")
            ))
        )
        list.add(Entity1("View 1"))
        list.add(Entity2("View 2"))
        list.add(
            Entity3(listOf(
                Entity4("Nested Item 1"),
            Entity4("Nested Item 2"),
            Entity4("Nested Item 3"),
            Entity4("Nested Item 4")
            ))
        )
        list.add(Entity1("View 1"))
        list.add(Entity2("View 2"))
        list.add(
            Entity3(listOf(
                Entity4("Nested Item 1"),
            Entity4("Nested Item 2"),
            Entity4("Nested Item 3"),
            Entity4("Nested Item 4")
            ))
        )
        list.add(Entity1("View 1"))
        list.add(Entity2("View 2"))
        return list
    }

}