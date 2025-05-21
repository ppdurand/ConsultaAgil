import './App.css'
import { ListPatients } from './pages/ListPatients/index.jsx'
import { RegisterPatient } from './pages/RegisterPatient/index.jsx'

function App() {
  return (
    <>
      <RegisterPatient />
      <ListPatients />
    </>
  )
}

export default App
