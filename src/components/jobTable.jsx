import * as React from 'react';
import {fetchJobs, fetchRecentJobs} from "../api/api";
import {Grid, ToggleButton, ToggleButtonGroup} from "@mui/material";
import {useEffect, useState} from "react";
import * as PropTypes from "prop-types";
import JobCard from "./jobCard";
import Button from "@mui/material/Button";


export default function JobTable() {
  const [jobs, setJobs] = useState([]);
  const [jobFilter, setJobFilter] = React.useState('all');

  const getJobs = async (setJobs, type) => {
    try {
      const jobs = type === 'recent' ? await fetchRecentJobs() : await fetchJobs();
      setJobs(jobs); // Store the fetched jobs in state
    } catch (error) {
      console.log(error);
    }
  }

    useEffect(() => {
      getJobs(setJobs, jobFilter); // Fetch jobs when the component mounts or jobType changes
    }, [jobFilter]);

    const handleJobFilter = (event, newJobFilter) => {
      if (newJobFilter !== null) {
        setJobFilter(newJobFilter);
      }
    }
  return (
      <>
        <Grid container spacing={2} alignItems="center" style={{ marginBottom: 20 }}>
          <Grid item xs={12} sm={3}></Grid>
          <Grid item xs={12} sm={6} container justifyContent="center">
            <ToggleButtonGroup
                value={jobFilter}
                exclusive
                onChange={handleJobFilter}
                aria-label="job type"
            >
              <ToggleButton value="recent" aria-label="recent jobs">
                Recent Jobs
              </ToggleButton>
              <ToggleButton value="active" aria-label="active jobs">
                Active Jobs
              </ToggleButton>
            </ToggleButtonGroup>
          </Grid>
          <Grid item xs={12} sm={3} container justifyContent="flex-end">
            <Button variant="contained" color="primary">
              Add New Job
            </Button>
          </Grid>
        </Grid>
      <Grid container spacing={2} justifyContent="center">
        {jobs.map((job) => (
            <Grid item xs={12} sm={6} md={4} lg={3} key={job.id}>
              <JobCard job={job}/>
            </Grid>
        ))}
      </Grid>
      </>

  );
}

JobCard.propTypes = {job: PropTypes.any};