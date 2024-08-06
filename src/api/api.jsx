// export function fetchAndDisplayTasks() {
//     fetchTasks()
//         .then(tasks => displayTasks(tasks))
// }

export async function fetchTasks() {
    const resp = await fetch(
        "http://0.0.0.0:8080/tasks",
        {
            headers: {'Accept': 'application/json', 'Content-Type': 'application/json'},
            method: 'GET'
        }
    );
    return await resp.json();
}