// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
document.querySelector("video").playbackRate=0.5;

const sections = document.querySelectorAll("section");
const navLi = document.querySelectorAll(".nav-menu ul li");

window.addEventListener("scroll", ()=>{
    let current = "";
    sections.forEach(section =>{
        const sectionTop = section.offsetTop;
        const sectionHeight = section.clientHeight;
        if(pageYOffset >= sectionTop - sectionHeight / 2){
            current = section.getAttribute("id");
        }
    })
    
    navLi.forEach(li =>{
        li.classList.remove("active");
        if(li.classList.contains(current)){
            li.classList.add("active");
        }
    })
})