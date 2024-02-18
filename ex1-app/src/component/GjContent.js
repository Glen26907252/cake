import React from 'react'
import Header from './header/header'
import Navigater from './navigater/navigater'
import Content from './content/content'
import Footer from './footer/footer'

export default function GjContent() {
  return (
    <div>
        <div className='header'><Header/></div>
        <div className='navigater'><Navigater/></div>
        <div className='content'><Content/></div>
        <div className='footer'><Footer/></div>

    </div>
  )
}