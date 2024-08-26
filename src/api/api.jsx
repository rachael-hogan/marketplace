// export function fetchAndDisplayTasks() {
//     fetchTasks()
//         .then(tasks => displayTasks(tasks))
// }

export async function fetchRecentJobs() {
    const resp = await fetch(
        "http://0.0.0.0:8080/jobs/recent",
        {
            headers: {'Accept': 'application/json', 'Content-Type': 'application/json'},
            method: 'GET'
        }
    );
    return resp.json();
}

export async function fetchJobs() {
    const resp = await fetch(
        "http://0.0.0.0:8080/jobs",
        {
            headers: {'Accept': 'application/json', 'Content-Type': 'application/json'},
            method: 'GET'
        }
    );
    return resp.json();
}

export async function getBids(jobDescription) {
    const resp = await fetch(
        `http://0.0.0.0:8080/bids/${jobDescription}`,
        {
            headers: {'Accept': 'application/json', 'Content-Type': 'application/json'},
            method: 'GET',
        }
    );
    return resp.json();
}

export async function fetchActiveJobs() {
    const resp = await fetch(
        "http://0.0.0.0:8080/jobs/active",
        {
            headers: {'Accept': 'application/json', 'Content-Type': 'application/json'},
            method: 'GET'
        }
    );
    return resp.json();
}

export async function createJob(job) {
    try {
        const resp = await fetch(
            "http://0.0.0.0:8080/jobs",
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(job)
            }
        );
        if (!resp.ok) {
            const errorText = await resp.text()
            console.error('Error response: ', errorText);
            throw new Error('Failed to create job');
        }

        const responseData = await resp.json();
        return responseData;
    } catch (error) {
        console.error('Error in createJob:', error);
        throw error;
    }
}

export async function createBid(bid, jobDescription) {
    try {
        const resp = await fetch(
            "http://0.0.0.0:8080/bids",
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: {
                    'bid': JSON.stringify(bid),
                    'jobDescription': jobDescription
                }
            }
        );
        if (!resp.ok) {
            const errorText = await resp.text()
            console.error('Error response: ', errorText);
            throw new Error('Failed to create job');
        }

        const responseData = await resp.json();
        return responseData;
    } catch (error) {
        console.error('Error in createJob:', error);
        throw error;
    }
}