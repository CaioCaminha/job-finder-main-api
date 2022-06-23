package com.caminha.service

import com.caminha.entity.Job

interface JobFinderService {
    fun getJobs(): List<Job>
    fun validateJobs(jobs: List<Job>): List<Job>
}