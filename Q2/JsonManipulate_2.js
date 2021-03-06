let jsonData = [
    {
      "id": 323,
      "username": "rinood30",
      "profile": {
        "full_name": "Shabrina Fauzan",
        "birthday": "1988-10-30",
        "phones": [
          "08133473821",
          "082539163912"
        ]
      },
      "articles:": [
        {
          "id": 3,
          "title": "Tips Berbagi Makanan",
          "published_at": "2019-01-03T16:00:00"
        },
        {
          "id": 7,
          "title": "Cara Membakar Ikan",
          "published_at": "2019-01-07T14:00:00"
        }
      ]
    },
    {
      "id": 201,
      "username": "norisa",
      "profile": {
        "full_name": "Noor Annisa",
        "birthday": "1986-08-14",
        "phones": []
      },
      "articles:": [
        {
          "id": 82,
          "title": "Cara Membuat Kue Kering",
          "published_at": "2019-10-08T11:00:00"
        },
        {
          "id": 91,
          "title": "Cara Membuat Brownies",
          "published_at": "2019-11-11T13:00:00"
        },
        {
          "id": 31,
          "title": "Cara Membuat Brownies",
          "published_at": "2019-11-11T13:00:00"
        }
      ]
    },
    {
      "id": 42,
      "username": "karina",
      "profile": {
        "full_name": "Karina Triandini",
        "birthday": "1986-04-14",
        "phones": [
          "06133929341"
        ]
      },
      "articles:": []
    },
    {
      "id": 201,
      "username": "icha",
      "profile": {
        "full_name": "Annisa Rachmawaty",
        "birthday": "1987-12-30",
        "phones": []
      },
      "articles:": [
        {
          "id": 39,
          "title": "Tips Berbelanja Bulan Tua",
          "published_at": "2019-04-06T07:00:00"
        },
        {
          "id": 43,
          "title": "Cara Memilih Permainan di Steam",
          "published_at": "2019-06-11T05:00:00"
        },
        {
          "id": 58,
          "title": "Cara Membuat Brownies",
          "published_at": "2019-09-12T04:00:00"
        }
      ]
    }
  ]

let nomor1 = jsonData
  .filter(user => user.profile.phones.length === 0)
  .map(user =>
      user.profile.full_name
  )
console.log("\n\nFind users who don't have any phone numbers. ")
console.log(nomor1)

let nomor2 = jsonData
  .filter(user => user["articles:"].length != 0)
  .map(user =>
      user.profile.full_name
  )
console.log("\n\nFind users who have articles. ")
console.log(nomor2)

let nomor3 = jsonData
  .filter(user => user.profile.full_name.toLowerCase().includes("annis"))
  .map(user =>
      user.profile.full_name
  )
console.log("\n\nFind users who have 'annis' on their name. ")
console.log(nomor3)

let nomor4 = jsonData
  .filter(user => user["articles:"].some(article => article.published_at.includes(2020)))
  .map(user => user.profile.full_name)
console.log("\n\nFind users who have articles on the year 2020.")
console.log(nomor4)

let nomor5 = jsonData
  .filter(user => user.profile.birthday.split("-")[0] === "1986")
  .map(user => user.profile.full_name)
console.log("\n\nFind users who are born in 1986. ")
console.log(nomor5)

let nomor6 = []
  jsonData.map((data, index) => 
      data["articles:"].filter(({title}) =>title.toLowerCase().includes("tips")).map(dataArticle => {
          nomor6.push(dataArticle)
      })
  )
console.log("\n\nFind articles that contain tips on the title.")
console.log(nomor6)

let nomor7 = []
  jsonData.map((data, index) => 
      data["articles:"].filter(({published_at}) => published_at.split("-")[0] < "2019").map(dataArticle => {
          nomor7.push(dataArticle)
      })
  )
console.log("\n\nFind articles published before August 2019.")
console.log(nomor7)
