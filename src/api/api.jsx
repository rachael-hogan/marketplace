// export function fetchAndDisplayTasks() {
//     fetchTasks()
//         .then(tasks => displayTasks(tasks))
// }

export async function fetchRecentJobs() {
    const resp = await fetch(
        "http://0.0.0.0:8080/tasks/recent",
        {
            headers: {'Accept': 'application/json', 'Content-Type': 'application/json'},
            method: 'GET'
        }
    );
    return resp.json();
}

export async function fetchJobs() {
    const resp = await fetch(
        "http://0.0.0.0:8080/tasks",
        {
            headers: {'Accept': 'application/json', 'Content-Type': 'application/json'},
            method: 'GET'
        }
    );
    return resp.json();
}