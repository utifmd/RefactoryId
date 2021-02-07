let jsonData = [
    {
    "inventory_id": 9382,
    "name": "Brown Chair",
    "type": "furniture",
    "tags": [
        "chair",
        "furniture",
        "brown"
    ],
    "purchased_at": 1579190471,
    "placement": {
        "room_id": 3,
        "name": "Meeting Room"
    }
    },
    {
    "inventory_id": 9380,
    "name": "Big Desk",
    "type": "furniture",
    "tags": [
        "desk",
        "furniture",
        "brown"
    ],
    "purchased_at": 1579190642,
    "placement": {
        "room_id": 3,
        "name": "Meeting Room"
    }
    },
    {
    "inventory_id": 2932,
    "name": "LG Monitor 50 inch",
    "type": "electronic",
    "tags": [
        "monitor"
    ],
    "purchased_at": 1579017842,
    "placement": {
        "room_id": 3,
        "name": "Lavender"
    }
    },
    {
    "inventory_id": 232,
    "name": "Sharp Pendingin Ruangan 2PK",
    "type": "electronic",
    "tags": [
        "ac"
    ],
    "purchased_at": 1578931442,
    "placement": {
        "room_id": 5,
        "name": "Dhanapala"
    }
    },
    {
    "inventory_id": 9382,
    "name": "Alat Makan",
    "type": "tableware",
    "tags": [
        "spoon",
        "fork",
        "tableware"
    ],
    "purchased_at": 1578672242,
    "placement": {
        "room_id": 10,
        "name": "Rajawali"
    }
    }
],
indonesianDate = (timeStamp) => {
    let date = new Date()
    date.setTime(timeStamp*1000)

    let tahun = date.getFullYear()
    let bulan = date.getMonth()
    let tanggal = date.getDate()
    let hari = date.getDay()

    bulan === 0 ? bulan = "Januari" 
    : bulan === 1 ? bulan = "Februari"
    : bulan === 2 ? bulan = "Maret"
    : bulan === 3 ? bulan = "April"
    : bulan === 4 ? bulan = "Mei"
    : bulan === 5 ? bulan = "Juni"
    : bulan === 6 ? bulan = "Juli"
    : bulan === 7 ? bulan = "Agustus"
    : bulan === 8 ? bulan = "September"
    : bulan === 9 ? bulan = "Oktober"
    : bulan === 10 ? bulan = "November"
    : bulan === 11 ? bulan = "Desember"
    : bulan = "invalid"
    
    return tanggal+" "+bulan+" "+tahun
}

let nomor1 = jsonData
    .filter(({placement}) => placement.name === "Meeting Room")
    .map(({name}) => name)
console.log(nomor1)

let nomor2 = jsonData
    .filter(({type}) => type === "electronic")
    .map(({name}) => name)
console.log(nomor2)

let nomor3 = jsonData
    .filter(({type}) => type === "furniture")
    .map(({name}) => name)
console.log(nomor3)

let nomor4 = jsonData
    .filter(({purchased_at}) => indonesianDate(purchased_at) === "16 Januari 2020")
    .map(({name}) => name)
console.log(nomor4)

let nomor5 = jsonData
    .filter(({tags}) => tags.includes("brown"))
    .map(({name}) => name)
console.log(nomor5)