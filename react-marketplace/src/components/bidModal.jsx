
import * as PropTypes from "prop-types";
import {getBids} from "../api/api";
import * as React from "react";
import {useEffect, useState} from "react";
import {Box, DialogContent, DialogTitle} from "@mui/material";

const BidModal = ({jobDescription}) => {
    const [bids, setBids] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchBids = async () => {
            try {
                const bidsData = await getBids(jobDescription);
                setBids(bidsData);
            } catch (error) {
                console.error("Error getting bids: ", error);
            } finally {
                setLoading(false);
            }
        };

        fetchBids();
    }, [jobDescription]);

    if (loading) {
        return <Box>Loading...</Box>;
    }

    return (
        <>
        <DialogTitle>Active Bids</DialogTitle>
        <DialogContent style={{ padding: 16 }}>
            {bids.length > 0 ? (
                bids.map((bid, index) => (
                    <div key={index}>
                        <p>{bid.bidderName} : {bid.bidAmount}</p>
                    </div>
                ))
            ) : (
                <p>No bids available!</p>
            )}
        </DialogContent>
        </>
    );
};

BidModal.propTypes = {
    jobDescription: PropTypes.string
};
export default BidModal;
