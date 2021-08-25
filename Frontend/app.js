'use strict';

const fs = require('fs');
const express =require('express');
const expressLayouts= require('express-ejs-layouts');
const bodyParser = require('body-parser');
const fetch = require('node-fetch');
const app=express();
const port = 2201;

// directorul 'views' va conține fișierele .ejs (html + js executat la server)
app.set('view engine', 'ejs');
// suport pentru layout-uri - implicit fișierul care reprezintă template-ul site-ului este views/layout.ejs
app.use(expressLayouts);
// directorul 'public' va conține toate resursele accesibile direct de către client (e.g., fișiere css, javascript, imagini)
app.use(express.static('public'))
// corpul mesajului poate fi interpretat ca json; datele de la formular se găsesc în format json în req.body
app.use(bodyParser.json());
// utilizarea unui algoritm de deep parsing care suportă obiecte în obiecte
app.use(bodyParser.urlencoded({extended:true}));

let listaPreturi;
fs.readFile('Preturi.json',(err, data)=>{
    if(err) throw err;
    listaPreturi = JSON.parse(data);
});
let listaPreturiAnalize;
fs.readFile('PreturiAnaliza.json',(err,data)=>{
    if(err) throw err;
    listaPreturiAnalize = JSON.parse(data);
});

app.get('/',(req,res)=>res.redirect('/acasa'));
app.get('/acasa',(req,res)=>{
    res.render("acasa");
});
app.get('/programare',async (req,res)=>{
    //iau toti medicii din baza de date pt a lua specializarile lor
    const url= "http://localhost:8080/api/doctors";
    const settings = {
        method:'GET',
        headers:{'Content-Type': 'application/json'}
    };
    const medici = await((await fetch(url,settings)).json());
    res.render("formular",{medici:medici});
});
app.post('/adauga-programare',async(req,res)=>{
    let date=JSON.stringify(req.body);
    console.log(req.body);
    date=JSON.parse(date);
    const url1= "http://localhost:8080/api/pacients/"+date.CNP;
    const settings1 = {
        method:'GET',
        headers:{'Content-Type': 'application/json'}
    };
    const pacienti = await((await fetch(url1,settings1)).json());
    if(pacienti.length==0)
    {
        res.sendStatus(404);
        return;
    }
    let bdy=JSON.stringify({id_programare: 1, id_doctor:date.specializare,id_pacient:pacienti[0].id_pacient, data_programare:date.programare})


    const url= "http://localhost:8080/api/programari/add";
    const settings = {
        method:'POST',
        headers:{'Content-Type': 'application/json'},
        body:bdy
    };
    const rawResponse =await((await fetch(url,settings)).json());
    console.log(rawResponse);
    res.render('confirmareProgramare')

})
app.get('/servicii', (req,res)=>{
    res.render("servicii");
});
app.get('/medici',async(req,res)=>{

    const url= "http://localhost:8080/api/doctors";
    const settings = {
        method:'GET',
        headers:{'Content-Type': 'application/json'}
    };
    const medici = await((await fetch(url,settings)).json());
    res.render("medici",{medici:medici});
});
app.get('/autentificare',(req,res)=>{
    res.render("autentificare");
});
app.post('/verificare-autentificare',(req,res)=>{
    res.render("formular");
})
app.get('/contact',(req,res)=>{
    res.render("contact");
});
app.get('/preturi',(req,res)=>{
    res.render('preturi',{Preturi:listaPreturi,PreturiAnaliza:listaPreturiAnalize});
});
app.get('/termeni',(req,res)=>{
    res.render("termeni");
});


app.get('/inregistrare',(req, res) => {
    res.render('inregistrare');
    
});
app.post('/adauga_client',(req,res)=>{
    let dataToInsert=JSON.stringify(req.body);
    var data=JSON.parse(dataToInsert)
    let bdy=JSON.stringify({id_pacient:1,nume_pacient:data.nume,CNP:data.cnp,telefon:data.telefon,adresa:data.adresa,email:data.email})
    const url= "http://localhost:8080/api/pacients/add";
    const settings = {
        method:'POST',
        headers:{'Content-Type': 'application/json'},
        body:bdy
       };
    (async () => {
        const rawResponse = await fetch(url,settings);
        const content = await rawResponse.json();
      
      })();
      res.render('autentificare');
});




app.listen(port,()=>console.log(`Serverul ruleaza la adresa http://localhost:`));
