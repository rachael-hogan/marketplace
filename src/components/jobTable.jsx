import * as React from 'react';
import {fetchTasks} from "../api/api";
import {Card, Grid} from "@mui/material";
import {useEffect, useState} from "react";
import * as PropTypes from "prop-types";
import JobCard from "./jobCard";

export default function JobTable() {
  const [jobs, setJobs] = useState([]);
  useEffect( () => {
    const fetchJobs = async () => {
      try {
        const tasks = await fetchTasks();
        debugger;
        setJobs(tasks);
      } catch (error) {
        console.log(error)
      }
    }
    fetchJobs();
  }, []);

  return (
      <Grid container spacing={2} justifyContent="center">
        {jobs.map((job) => (
            <Grid item xs={12} sm={6} md={4} lg={3} key={job.id}>
              <JobCard job={job} />
            </Grid>
        ))}
      </Grid>
  );
}

JobCard.propTypes = {job: PropTypes.any};