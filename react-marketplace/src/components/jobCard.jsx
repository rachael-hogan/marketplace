import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import {Box, Dialog, Drawer, Modal} from "@mui/material";
import BidForm from "./bidForm";
import {useState} from "react";
import BidModal from "./bidModal";

export default function JobCard({job}) {
    const [drawerOpen, setAddBidDrawerOpen] = useState(false);
    const [modalOpen, setBidModalOpen] = useState(false);
    return (
        <>
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
                <Button size="small" variant="contained" color="primary" onClick={() => {setAddBidDrawerOpen(true)}}>Add Bid</Button>
                <Button size="small" variant="outlined" color="primary" onClick={() => {setBidModalOpen(true)}}>Show Bids</Button>
            </CardActions>
            <Drawer open={drawerOpen} onClose={() => {setAddBidDrawerOpen(false)}}>
                <BidForm jobDescription={job.description}></BidForm>
            </Drawer>
        </Card>
            <Dialog open={modalOpen} onClose={() => {setBidModalOpen(false)}} >
                <BidModal jobDescription={job.description}></BidModal>
            </Dialog>
    </>
    );
}

