import './App.css'
import { AppRoutes } from './Routes/Routes.jsx'
import { HamburgerMenu } from './HamburgerMenu.jsx';
import { BrowserRouter } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <HamburgerMenu />
      <AppRoutes/>
    </BrowserRouter>
  )
}

export default App
