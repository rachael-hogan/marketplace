import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import {Drawer} from "@mui/material";
import BidForm from "./bidForm";
import * as PropTypes from "prop-types";
import {useState} from "react";

export default function JobCard({job}) {
    const [drawerOpen, setDrawerOpen] = useState(false);
    return (
        <Card sx={{ minWidth: 275, marginBottom: 2 }} key={job.id}>
            <CardContent>
                <Typography variant="h5" component="div">
                    {job.title}
                </Typography>
                <Typography sx={{ mb: 1.5 }} color="text.secondary">
                    {job.description}
                </Typography>
                <Typography variant="body2">
                    Steps: {job.requirements}
                </Typography>
                <Typography variant="body2">
                    Date: {job.createdAt}
                </Typography>
            </CardContent>
            <CardActions>
                <Button size="small" variant="contained" color="secondary" onClick={() => {setDrawerOpen(true)}}>Add Bid</Button>
            </CardActions>
            <Drawer open={drawerOpen} onClose={() => {setDrawerOpen(false)}}>
                <BidForm></BidForm>
            </Drawer>
        </Card>
    );
}

