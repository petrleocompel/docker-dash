const serverURL = "http://localhost:5000";
const basePath = serverURL + "/v2/";
const mock = true;


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
    return {fetch: fetch(basePath + "get-all"), mock: mockGetAll()};

}

export function mockGetAll() {
    return [
        {id: 1, name: 'PUBG_server', mountpoint: "URL TODO" },
        {id: 2, name: 'Minecraft_server', mountpoint: "URL TODO"},
        {id: 3, name: 'Dota_server', mountpoint: "URL TODO" }];
}

export function enviroment() {
    return {fetch: fetch(basePath + "environment"), mock: [
        {
            "services": [
                {
                    "id": "string",
                    "path": "string",
                    "args": [
                        "string"
                    ],
                    "image": "string",
                    "name": "string"
                }
            ]
        }
    ]};
    
}