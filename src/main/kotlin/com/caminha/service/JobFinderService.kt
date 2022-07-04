package com.caminha.service

import com.caminha.entity.JobEntity


interface JobFinderService {
    fun getJobs(): String
    fun validateJobs(jobs: List<JobEntity>): List<JobEntity>
}