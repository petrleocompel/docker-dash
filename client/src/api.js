const serverURL = "http://localhost:5000";
const basePath = serverURL + "/v2/";
const mock = true;


export function responsr(fetchCallback) {
    if (mock === true) {
        return new Promise((resolve)=>{return resolve(fetchCallback.mock)});
    }
    fetchCallback.fetch.then(function (response) {
        if (response.ok) {
            return response.json();
        }

        throw new Error('Chyba zpracovani TODO');

    }).catch(function (error) {
        console.log(error);
    })
}


export function getAll() {
    return {fetch: fetch(basePath + "get-all"), mock: mockGetAll()};

}

export function mockGetAll() {
    return [
        {id: 1, name: 'PUBG_server', mountpoint: "URL TODO" },
        {id: 2, name: 'Minecraft_server', mountpoint: "URL TODO"},
        {id: 3, name: 'Dota_server', mountpoint: "URL TODO" }];
}