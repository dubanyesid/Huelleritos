let estaSubida=false;
const imageUploader = document.getElementById('img-uploader');
const imageUploadbar = document.getElementById('img-upload-bar');
const inurl = document.getElementById('in-url');
let CLOUDINARY_URL = "";
const CLOUDINARY_UPLOAD_PRESET = 'cf9ma2zl';
let file;
imageUploader.addEventListener('change', async(e) => {
if(estaSubida){
alert("esta subida");
return;
}
    console.log(e);
     file= e.target.files[0];
    console.log()
    if(file.type.includes("video")){
CLOUDINARY_URL=`https://api.cloudinary.com/v1_1/dfxfvf7ka/video/upload`
    }else if(file.type.includes("image")){
CLOUDINARY_URL=`https://api.cloudinary.com/v1_1/dfxfvf7ka/image/upload`
    }
    const nombreArchivo=file.name.length > 20 ? file.name.substr(0,17)+"...":file.name;
    console.log(nombreArchivo);
    document.getElementById("lblArchivo").innerHTML=nombreArchivo
    // Send to cloudianry
  
   
    

});

document.getElementById("upload").addEventListener("click",async(e)=>{
if(estaSubida){
alert("esta subida");
return;
}
console.log("entro")
    const formData = new FormData();
    formData.append('file', file);
    formData.append('upload_preset', CLOUDINARY_UPLOAD_PRESET);
      const res = await axios.post(
        CLOUDINARY_URL,
        formData, {
            headers: {
                'Content-Type': 'multipart/form-data'
            },
            onUploadProgress(e) {
                let progress = Math.round((e.loaded * 100.0) / e.total);
                console.log(progress);
                imageUploadbar.setAttribute('value', progress);
            }
        }
    );
    inurl.setAttribute("value", res.data.secure_url);
    estaSubida=true;
       console.log(res.data.secure_url)
})