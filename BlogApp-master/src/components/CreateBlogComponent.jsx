// import React, { PureComponent } from 'react'
// import { json,Link } from 'react-router-dom';
// import BlogService from '../services/BlogService';

// class CreateBlogComponent extends PureComponent {
//     constructor(props) {
//         super(props)

//         this.state = {
//             title: '',
//             email: '',
//             userId: '',
//             content: '',

//         }
//         this.changetitleHandler=this.changetitleHandler.bind(this);
//         this.changeemailHandler=this.changeemailHandler.bind(this);
//         this.changeuserIdHandler=this.changeuserIdHandler.bind(this);
//         this.changecontentHandler=this.changecontentHandler.bind(this);
//         this.saveBlog=this.saveBlog.bind(this);
//     }
//     saveBlog (){
//         let blog={title: this.state.title, email: this.state.email,userId: this.state.userId, content: this.state.content}
//          console.log("blog =>" + JSON.stringify(blog));
//          if(this.state.userId.length==0 ||this.state.email.length==0|| this.state.title.length==0 || this.state.content.length==0)
//         {
//              window.alert("Enter all the fields");
//              return;
//         }
//          BlogService.createBlog(blog).then(res=>{
//            console.log(res);
//          })
//     }
//     changetitleHandler= (event)=>{
//         this.setState({title: event.target.value});
//     }
//     changeemailHandler= (event)=>{
//         this.setState({email: event.target.value});
//     }
//     changeuserIdHandler= (event)=>{
//         this.setState({userId: event.target.value});
//     }
//     changecontentHandler= (event)=>{
//         this.setState({content: event.target.value});
//     }
//     cancel(){
//         //this.props.history.push('/blogs');
//     }

//     render() {
//         return (
//             <div>
//                 <div className='container'>
//                     <div className='row'>
//                         <div className='card col-md-6 offset-md-3 offset-md-3'>
//                             <h3 className='text-center'>Add Blog</h3>
//                             <div className='card-body'>
                               
//                                 <form class="row g-3 needs-validation" novalidate> 
//                                     <div class="form-group" for="validationCustom01">
//                                         <label for="exampleFormControlInput1">Title</label>
//                                         <input type="title" class="form-control" id="exampleFormControlInput1" placeholder="title" onChange={this.changetitleHandler}/>
//                                     </div>
//                                     <div class="form-group" for="validationCustom01">
//                                         <label for="exampleFormControlInput1">Email-Id</label>
//                                         <input type="email" class="form-control" id="exampleFormControlInput2" placeholder="email" onChange={this.changeemailHandler}/>
//                                     </div>
//                                     <div class="form-group" for="validationCustom01">
//                                         <label for="exampleFormControlInput1">userId</label>
//                                         <input type="userId" class="form-control" id="exampleFormControlInput3" placeholder="userId" onChange={this.changeuserIdHandler}/>
//                                     </div>
//                                     <div className='form-group' for="validationCustom01">
//                                         {/* <label>content</label>
//                                         <input placeholder='content' name='content' className='form-control'
//                                         value={this.state.content} onChange={this.changecontentHandler}/> */}
//                                          <label for="exampleFormControlTextarea1">content</label>
//                                             <textarea placeholder='content' name='content' onChange={this.changecontentHandler} class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
//                                     </div>
                                    
//                                     <div className='form-group' >
//                                 <Link to='/blogs' onClick={this.saveBlog.bind(this)} className='btn btn-primary w-60'>Save and send mail</Link>
//                                     </div>
//                                     {/* <button className='btn btn-danger' onClick={this.cancel.bind(this)} style={{marginLeft:"10px"}}>Cancel</button> */}
//                                     <div className='form-group' >
//                                     <Link to='/blogs' onClick={this.cancel.bind(this)} className='btn btn-primary w-60'>Cancel</Link>
//                                     </div>
//                                     </form>
//                             </div>
//                         </div>
//                     </div>
//                 </div>
//             </div>
//         )
//     }
// }

// export default CreateBlogComponent

import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import BlogService from '../services/BlogService';

const CreateBlogComponent = () => {
  const [title, setTitle] = useState('');
  const [email, setEmail] = useState('');
  const [userId, setUserId] = useState('');
  const [content, setContent] = useState('');

  const saveBlog = () => {
    if (userId.length === 0 || email.length === 0 || title.length === 0 || content.length === 0) {
      window.alert("Enter all the fields");
      return;
    }
    const blog = { title, email, userId, content };
    console.log("blog =>", JSON.stringify(blog));
    BlogService.createBlog(blog).then(res => {
      console.log(res);
    });
  }

  return (
    <div>
      <div className='container'>
        <div className='row'>
          <div className='card col-md-6 offset-md-3 offset-md-3'>
            <h3 className='text-center'>Add Blog</h3>
            <div className='card-body'>
              <form className="row g-3 needs-validation" noValidate>
                <div className="form-group" for="validationCustom01">
                  <label for="exampleFormControlInput1">Title</label>
                  <input type="title" className="form-control" id="exampleFormControlInput1" placeholder="title" onChange={(e) => setTitle(e.target.value)} />
                </div>
                <div className="form-group" for="validationCustom01">
                  <label for="exampleFormControlInput1">Email-Id</label>
                  <input type="email" className="form-control" id="exampleFormControlInput2" placeholder="email" onChange={(e) => setEmail(e.target.value)} />
                </div>
                <div className="form-group" for="validationCustom01">
                  <label for="exampleFormControlInput1">userId</label>
                  <input type="userId" className="form-control" id="exampleFormControlInput3" placeholder="userId" onChange={(e) => setUserId(e.target.value)} />
                </div>
                <div className='form-group' for="validationCustom01">
                  <label for="exampleFormControlTextarea1">content</label>
                  <textarea placeholder='content' name='content' onChange={(e) => setContent(e.target.value)} className="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                </div>

                <div className='form-group'>
                  <Link to='/blogs' onClick={saveBlog} className='btn btn-primary w-60'>Save and send mail</Link>
                </div>
                <div className='form-group'>
                  <Link to='/blogs' className='btn btn-primary w-60'>Cancel</Link>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default CreateBlogComponent;
