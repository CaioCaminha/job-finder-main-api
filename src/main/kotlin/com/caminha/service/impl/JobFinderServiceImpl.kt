package com.caminha.service.impl

import com.caminha.entity.Job
import com.caminha.service.JobFinderService
import jakarta.inject.Singleton

@Singleton
class JobFinderServiceImpl: JobFinderService {
    override fun getJobs(): List<Job> {
        TODO("Not yet implemented")
    }

    override fun validateJobs(jobs: List<Job>): List<Job> {
        TODO("Not yet implemented")
    }
}