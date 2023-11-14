
var obj = {
    msg: " "
}

const myMD = require('../model/SanPhamModel')

exports.getSP = async (req,res, next) =>{
    var listProduct = await myMD.productModel.find()
    // let listProduct = []
    

    res.json(listProduct)

}
exports.add = async (req, res, next) => {
    console.log("Thêm Sản Phẩm");
    let msg = "";
  
    if (req.method === "POST") {
        
      try {
        // let image = "";
        // if (req.file != null) {
        //   const destinationPath = path.join(__dirname, "../public/templates");
        //   const tempFilePath = req.file.path;
        //   const originalName = req.file.originalname;
  
        //   fs.renameSync(tempFilePath, path.join(destinationPath, originalName));
        //   console.log("Url: http://localhost:8080/templates/" + originalName + "success");
          
        //   image = "/templates/" + originalName;
        //}
  
        const objSP = new myMD.productModel({
          nameproduct: req.body.nameproduct,
          price: req.body.price,
          description: req.body.description,
          image: req.body.image
          
        });
  
        const new_sp = await objSP.save();
        console.log(new_sp);
        msg = "Đã thêm thành công";
        res.json(new_sp)
      } catch (error) {
        msg = "Lỗi: " + error.message;
        console.error(error);
      }
    }
  
   
  };

  exports.deleteProduct = async (req, res, next) => {
    const idPro = req.body._id;
    console.log(idPro);
  
    try {
      await myMD.productModel.deleteOne({ _id: idPro });
      obj.msg="đã xóa"
    } catch (error) {
      console.error(error);
      res.status(500).send("Đã xảy ra lỗi trong quá trình xóa sản phẩm.");
    }

    res.json(obj)
  };
  