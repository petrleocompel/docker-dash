import reducers from './reducers/rootReducer'
import {createStore} from 'redux'


let store = createStore(reducers);
export default store