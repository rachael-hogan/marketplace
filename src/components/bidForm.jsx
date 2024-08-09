import React, { useState } from 'react';
import {TextField, Button, Box, Drawer} from '@mui/material';
import * as PropTypes from "prop-types";
import {createBid, createJob} from "../api/api";
import {delayHideSpinner} from "../utils/utils";

const BidForm = () => {
    const [name, setName] = useState('');
    const [amount, setAmount] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();

        // Create a bid object
        const bid = {
            bidderName: name,
            bidAmount: parseFloat(amount),
            bidTime: new Date().toISOString(),
        };

        // Pass the bid to the parent component or handle it here
        try {
            console.log("newBid: ", bid);
            await createBid(bid);
        } catch (error) {
            console.error("Error saving bid: ", error);
        } finally {
            //delayHideSpinner(() => setLoading(false));
        }

        // Clear the form fields
        setName('');
        setAmount('');
    };

    return (

            <Box
                component="form"
                onSubmit={handleSubmit}
                sx={{ mt: 3, display: 'flex', flexDirection: 'column', gap: 2 }}
            >
            <TextField
                label="Your Name"
                variant="outlined"
                value={name}
                onChange={(e) => setName(e.target.value)}
                required
            />
            <TextField
                label="Bid Amount"
                variant="outlined"
                type="number"
                value={amount}
                onChange={(e) => setAmount(e.target.value)}
                required
            />
            <Button type="submit" variant="contained" color="primary">
                Submit Bid
            </Button>
            </Box>
    );
};

BidForm.propTypes = {
    isOpen: PropTypes.any
};
export default BidForm;
