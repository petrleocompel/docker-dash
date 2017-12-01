const serverURL = "http://localhost:4000";
const basePath = serverURL + "/api/";


export function responsr(fetchCallback) {
    return fetchCallback.then(function (response) {
        if (response.ok) {
            return response.text().then(function(text) {
                return text ? JSON.parse(text) : null
            });
        }


        return response.json().then((error) => {console.log(error);return Promise.reject()});


    }).catch(function (error) {
        console.log(error);
        return Promise.reject();
    })
}


export function getAll() {
    return responsr(fetch(basePath + "get-all"));

}

export function environment() {
    return responsr(fetch(basePath + "environment"));
}

/*
export function environment(id){
    return responsr(fetch(basePath + "environment/" + id));
}
*/

export function environmentDelete(id){
    return responsr(fetch(basePath + "environment/" + id, {method: 'DELETE'}));
}

export function environmentStop(id){
    return responsr(fetch(basePath + "environment/" + id + "/stop", {method: 'POST'}));
}

export function environmentStart(id){
    return responsr(fetch(basePath + "environment/" + id + "/start", {method: 'POST'}));
}

export function environmentRestart(id){
    return responsr(fetch(basePath + "environment/" + id + "/restart", {method: 'POST'}));
}

export function instance(id){
    return responsr(fetch(basePath + "instance/" + id));
}
export function instanceDelete(id){
    return responsr(fetch(basePath + "instance/" + id, {method: 'DELETE'}));
}

export function instanceStop(id){
    return responsr(fetch(basePath + "instance/" + id + "/stop", {method: 'POST'}));
}

export function instanceStart(id){
    return responsr(fetch(basePath + "instance/" + id + "/start", {method: 'POST'}));
}

export function instanceRestart(id){
    return responsr(fetch(basePath + "instance/" + id + "/restart", {method: 'POST'}));
}

