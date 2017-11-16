const serverURL = "http://localhost:4000";
const basePath = serverURL + "/api/";
const mock = false;


export function responsr(fetchCallback) {
    if (mock === true) {
        return new Promise((resolve)=>{return resolve(fetchCallback.mock)});
    }
    return fetchCallback.fetch.then(function (response) {
        if (response.ok) {
            return response.json();
        }


        return response.json().then((error) => {console.log(error);return Promise.reject()});


    }).catch(function (error) {
        console.log(error);
        return Promise.reject();
    })
}


export function getAll() {
    return {fetch: fetch(basePath + "get-all")};

}

export function mockGetAll() {
    return [
        {id: 1, name: 'PUBG_server', mountpoint: "URL TODO" },
        {id: 2, name: 'Minecraft_server', mountpoint: "URL TODO"},
        {id: 3, name: 'Dota_server', mountpoint: "URL TODO" }];
}

export function environment() {
    return {fetch: fetch(basePath + "environment")}
}

/*
export function environment(id){
    return {fetch: fetch(basePath + "environment/" + id)}
}
*/

export function environmentDelete(id){
    return {fetch: fetch(basePath + "environment/" + id, {method: 'DELETE'})}
}

export function environmentStop(id){
    return {fetch: fetch(basePath + "environment/" + id + "/stop", {method: 'POST'})}
}

export function environmentStart(id){
    return {fetch: fetch(basePath + "environment/" + id + "/start", {method: 'POST'})}
}

export function environmentRestart(id){
    return {fetch: fetch(basePath + "environment/" + id + "/restart", {method: 'POST'})}
}

export function instance(id){
    return {fetch: fetch(basePath + "instance/" + id)}
}
export function instanceDelete(id){
    return {fetch: fetch(basePath + "instance/" + id, {method: 'DELETE'})}
}

export function instanceStop(id){
    return {fetch: fetch(basePath + "instance/" + id + "/stop", {method: 'POST'})}
}

export function instanceStart(id){
    return {fetch: fetch(basePath + "instance/" + id + "/start", {method: 'POST'})}
}

export function instanceRestart(id){
    return {fetch: fetch(basePath + "instance/" + id + "/restart", {method: 'POST'})}
}

