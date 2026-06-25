package com.skillforge.app.data.model

data class Course(
    val id: String,
    val title: String,
    val subtitle: String,
    val thumbnailURL: String,
    val level: String,
    val durationHours: Double,
    val rating: Double,
    val studentsEnrolled: Int,
    val language: String,
    val lastUpdated: String,
    val tags: List<String>,
    val instructor: List<Instructor>,
    val description: String,
    val lessons: List<Lesson>
)
